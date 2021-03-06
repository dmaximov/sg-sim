package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class AgentForWbReciever extends Behaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Agent myAgent;
	
	public AgentForWbReciever(Agent a) {
		this.myAgent = a;
		try {
			MessageTemplate template = MessageTemplate.and(
					MessageTemplate.MatchProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST),
					MessageTemplate.MatchPerformative(ACLMessage.REQUEST));
	
			myAgent.addBehaviour(new AgentForWbRequestResponderBehaviour(this.myAgent, template));        
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		/*try {
			MessageTemplate template = MessageTemplate.and(
					MessageTemplate.MatchProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST),
					MessageTemplate.MatchPerformative(ACLMessage.REQUEST));
	
			myAgent.addBehaviour(new AgentForWbRequestResponderBehaviour(this.myAgent, template));        
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}*/
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return false;
	}

}
