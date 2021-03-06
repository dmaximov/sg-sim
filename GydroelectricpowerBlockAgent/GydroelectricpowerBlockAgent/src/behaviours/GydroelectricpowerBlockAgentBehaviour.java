package behaviours;

import jade.core.Agent;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.SubscriptionResponder;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import ontologies.*;

import java.lang.Math;

public class GydroelectricpowerBlockAgentBehaviour extends TickerBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int consumption;
	private double perfomance;
	private int pressure;
	private double constg;
	private double current_power;
	private double assigned_power;
	private SubscriptionResponder dfSubscriptionResponder;
	private StateSubscriptionManager subManager;
	
	private double transitionDelta;
	private boolean isInTransition;

	public GydroelectricpowerBlockAgentBehaviour(Agent a, int cons, double perf, int pres, double constg, StateSubscriptionManager subManager, SubscriptionResponder dfSubscriptionResp) {
		super(a, 5000);
		this.perfomance=perf;
		this.constg=constg;
		this.pressure=pres;
		this.consumption=cons;
		current_power=max_power_calc();
		this.assigned_power=this.current_power;
		this.subManager=subManager;
		this.dfSubscriptionResponder=dfSubscriptionResp;
		this.isInTransition = false;
		
		this.subManager.setGydroelectricpowerBlock(this);
		
		try {
			MessageTemplate template = MessageTemplate.and(
					MessageTemplate.MatchProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST),
					MessageTemplate.MatchPerformative(ACLMessage.REQUEST));

			myAgent.addBehaviour(new GydroelectricpowerBlockAgentRequestResponderBehaviour(this, this.myAgent, template));        
			System.out.println("Registered a Request Responder");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public boolean setAssignedPower(double requested_assigned_power) {
		if(this.check_assign(requested_assigned_power)) {
			this.assigned_power = requested_assigned_power;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void onTick() {
		System.out.print("Current Power: ");
		System.out.println(this.current_power);		
		System.out.print("Assigned_power: ");
		System.out.println(this.assigned_power);
		System.out.print("Time Delay: ");
		System.out.println(this.time_delay());
		if(isInTransition) {
			System.out.println("Perfoming a transition step");
			if(current_power != assigned_power) {
				current_power -= transitionDelta;
				if (Math.abs(current_power - assigned_power) < transitionDelta) {
					current_power = assigned_power; 
					isInTransition = false;
					transitionDelta = 0;
				}
			} else {
				isInTransition = false;
				transitionDelta = 0;
			}
			
			if(!isInTransition) {
				System.out.println("Transition to new power value completed");
			}
		}
	}

	public void change_power() {
		double delta = (current_power - assigned_power) / time_delay();
		
		transitionDelta = delta;
		isInTransition = true;
		
		System.out.println("Entering a transient state");
	}

	public double max_power_calc ()
	{
		return this.pressure*this.constg*this.consumption;
	}

	public double time_delay() {
		double delta=Math.abs(10*(current_power-assigned_power)/max_power_calc());
		if (delta<0) return 1;
		else return delta;
	}

	public boolean check_assign(double requested_assigned_power){
		if (requested_assigned_power > this.max_power_calc() 
				|| requested_assigned_power < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public State getState() {
		State state = new State();
		state.setCurrentPower(this.current_power);
		state.setMaxPower(this.max_power_calc());
		state.setState((this.current_power > 0));
		return state;
	}
	
	public double getCurrentPower() {
		return current_power;
	}
}
