package org.metaabm.examples.stupid2;

import org.eclipse.amp.agf.IGraphicsAdapter;
import org.eclipse.amp.agf.GraphicsAdapter;
import org.eclipse.amp.agf.gef.IFigureProvider;
import org.eclipse.core.runtime.IAdapterFactory;

import org.eclipse.amp.agf.gef.IFigureProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProvider;

/**
 * <!-- begin-user-doc -->
 * Stupid Model 2 Java Implementation.
 * 
 * Generated by AMF for model: StupidModel2.metaabm in project: org.eclipse.amp.amf.examples.escape 
 * <!-- end-user-doc -->
 * @generated
 */
public class StupidModel2GraphicsAdapter extends GraphicsAdapter {

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static IGraphicsAdapter singleton;

	IColorProvider[] stupidModel2ColorProviders = new IColorProvider[]{};
	IColorProvider[] bugColorProviders = new IColorProvider[]{BugStyle2DColorProvider
			.getDefault()};
	IColorProvider[] habitatColorProviders = new IColorProvider[]{HabitatStyle2DColorProvider
			.getDefault()};

	IFigureProvider[] stupidModel2FigureProviders = new IFigureProvider[]{};
	IFigureProvider[] bugFigureProviders = new IFigureProvider[]{BugStyle2DFigureProvider
			.getDefault()};
	IFigureProvider[] habitatFigureProviders = new IFigureProvider[]{HabitatStyle2DFigureProvider
			.getDefault()};

	/**
	 * <!-- begin-user-doc -->
	 * @param type
	 * @return
	 * @see org.eclipse.amp.agf.IGraphicsAdapter#getColorsForClass(java.lang.Class)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IColorProvider[] getColorsForClass(Class type) {
		if (type == StupidModel2.class) {
			return stupidModel2ColorProviders;
		}
		if (type == Bug.class) {
			return bugColorProviders;
		}
		if (type == Habitat.class) {
			return habitatColorProviders;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @param type
	 * @return
	 * @see org.eclipse.amp.agf.IGraphicsAdapter#getFiguresForClass(java.lang.Class)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFigureProvider[] getFiguresForClass(Class type) {
		if (type == StupidModel2.class) {
			return stupidModel2FigureProviders;
		}
		if (type == Bug.class) {
			return bugFigureProviders;
		}
		if (type == Habitat.class) {
			return habitatFigureProviders;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @param type
	 * @return
	 * @see org.eclipse.amp.agf.IGraphicsAdapter#getLabelsForClass(java.lang.Class)
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ILabelProvider[] getLabelsForClass(Class type) {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IGraphicsAdapter getDefault() {
		if (singleton == null) {
			singleton = new StupidModel2GraphicsAdapter();
		}
		return singleton;
	}
}
