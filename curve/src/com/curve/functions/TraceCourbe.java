package com.curve.functions;

import com.curve.ui.DessinFrame;

import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by donatien on 13/04/14.
 */
public class TraceCourbe extends CubicCurve2D {

    Point p1,p2,ctrlp1,ctrlp2;
    public TraceCourbe(Point p1, Point p2, DessinFrame d){

        this.p1=p1;
        this.p2=p2;

        // creation des points de controle de la courbe
        this.ctrlp1= new Point(p1.x,p1.y+50);
        this.ctrlp2=new Point(p2.x,p2.y+50);
        d.getGraphics().fillRect(ctrlp1.x,ctrlp1.y,5,5);
        d.getGraphics().fillRect(ctrlp2.x,ctrlp2.y,5,5);

        //add points to curvepoints

        d.getCurvepoints().addElement(ctrlp2);
        d.getCurvepoints().addElement(ctrlp1);
        d.getCurvepoints().addElement(p2);

    }
    /**
     * Returns the X coordinate of the start point in double precision.
     *
     * @return the X coordinate of the start point of the
     * {@code CubicCurve2D}.
     * @since 1.2
     */
    @Override
    public double getX1() {
        return p1.x;
    }

    /**
     * Returns the Y coordinate of the start point in double precision.
     *
     * @return the Y coordinate of the start point of the
     * {@code CubicCurve2D}.
     * @since 1.2
     */
    @Override
    public double getY1() {
        return p1.y;
    }

    /**
     * Returns the start point.
     *
     * @return a {@code Point2D} that is the start point of
     * the {@code CubicCurve2D}.
     * @since 1.2
     */
    @Override
    public Point2D getP1() {
        return p1;
    }

    /**
     * Returns the X coordinate of the first control point in double precision.
     *
     * @return the X coordinate of the first control point of the
     * {@code CubicCurve2D}.
     * @since 1.2
     */
    @Override
    public double getCtrlX1() {
        return ctrlp1.x;
    }

    /**
     * Returns the Y coordinate of the first control point in double precision.
     *
     * @return the Y coordinate of the first control point of the
     * {@code CubicCurve2D}.
     * @since 1.2
     */
    @Override
    public double getCtrlY1() {
        return ctrlp1.y;
    }

    /**
     * Returns the first control point.
     *
     * @return a {@code Point2D} that is the first control point of
     * the {@code CubicCurve2D}.
     * @since 1.2
     */
    @Override
    public Point2D getCtrlP1() {
        return ctrlp1;
    }

    /**
     * Returns the X coordinate of the second control point
     * in double precision.
     *
     * @return the X coordinate of the second control point of the
     * {@code CubicCurve2D}.
     * @since 1.2
     */
    @Override
    public double getCtrlX2() {
        return ctrlp2.x;
    }

    /**
     * Returns the Y coordinate of the second control point
     * in double precision.
     *
     * @return the Y coordinate of the second control point of the
     * {@code CubicCurve2D}.
     * @since 1.2
     */
    @Override
    public double getCtrlY2() {
        return ctrlp2.y;
    }

    /**
     * Returns the second control point.
     *
     * @return a {@code Point2D} that is the second control point of
     * the {@code CubicCurve2D}.
     * @since 1.2
     */
    @Override
    public Point2D getCtrlP2() {
        return ctrlp2;
    }

    /**
     * Returns the X coordinate of the end point in double precision.
     *
     * @return the X coordinate of the end point of the
     * {@code CubicCurve2D}.
     * @since 1.2
     */
    @Override
    public double getX2() {
        return p2.x;
    }

    /**
     * Returns the Y coordinate of the end point in double precision.
     *
     * @return the Y coordinate of the end point of the
     * {@code CubicCurve2D}.
     * @since 1.2
     */
    @Override
    public double getY2() {
        return p2.y;
    }

    /**
     * Returns the end point.
     *
     * @return a {@code Point2D} that is the end point of
     * the {@code CubicCurve2D}.
     * @since 1.2
     */
    @Override
    public Point2D getP2() {
        return p2;
    }

    /**
     * Sets the location of the end points and control points of this curve
     * to the specified double coordinates.
     *
     * @param x1     the X coordinate used to set the start point
     *               of this {@code CubicCurve2D}
     * @param y1     the Y coordinate used to set the start point
     *               of this {@code CubicCurve2D}
     * @param ctrlx1 the X coordinate used to set the first control point
     *               of this {@code CubicCurve2D}
     * @param ctrly1 the Y coordinate used to set the first control point
     *               of this {@code CubicCurve2D}
     * @param ctrlx2 the X coordinate used to set the second control point
     *               of this {@code CubicCurve2D}
     * @param ctrly2 the Y coordinate used to set the second control point
     *               of this {@code CubicCurve2D}
     * @param x2     the X coordinate used to set the end point
     *               of this {@code CubicCurve2D}
     * @param y2     the Y coordinate used to set the end point
     *               of this {@code CubicCurve2D}
     * @since 1.2
     */
    @Override
    public void setCurve(double x1, double y1, double ctrlx1, double ctrly1, double ctrlx2, double ctrly2, double x2, double y2) {
        p1.x= (int) x1;
        p1.y= (int) y1;
        ctrlp1.x= (int) ctrlx1;
        ctrlp1.y= (int) ctrly1;
        ctrlp2.x= (int) ctrlx2;
        ctrlp2.y= (int) ctrly2;

    }

    /**
     * Returns a high precision and more accurate bounding box of
     * the <code>Shape</code> than the <code>getBounds</code> method.
     * Note that there is no guarantee that the returned
     * {@link java.awt.geom.Rectangle2D} is the smallest bounding box that encloses
     * the <code>Shape</code>, only that the <code>Shape</code> lies
     * entirely within the indicated <code>Rectangle2D</code>.  The
     * bounding box returned by this method is usually tighter than that
     * returned by the <code>getBounds</code> method and never fails due
     * to overflow problems since the return value can be an instance of
     * the <code>Rectangle2D</code> that uses double precision values to
     * store the dimensions.
     * <p/>
     * <p>
     * Note that the <a href="{@docRoot}/java/awt/Shape.html#def_insideness">
     * definition of insideness</a> can lead to situations where points
     * on the defining outline of the {@code shape} may not be considered
     * contained in the returned {@code bounds} object, but only in cases
     * where those points are also not considered contained in the original
     * {@code shape}.
     * </p>
     * <p>
     * If a {@code point} is inside the {@code shape} according to the
     * {@link #contains(java.awt.geom.Point2D p) contains(point)} method, then it must
     * be inside the returned {@code Rectangle2D} bounds object according
     * to the {@link #contains(java.awt.geom.Point2D p) contains(point)} method of the
     * {@code bounds}. Specifically:
     * </p>
     * <p>
     * {@code shape.contains(p)} requires {@code bounds.contains(p)}
     * </p>
     * <p>
     * If a {@code point} is not inside the {@code shape}, then it might
     * still be contained in the {@code bounds} object:
     * </p>
     * <p>
     * {@code bounds.contains(p)} does not imply {@code shape.contains(p)}
     * </p>
     *
     * @return an instance of <code>Rectangle2D</code> that is a
     * high-precision bounding box of the <code>Shape</code>.
     * @see #getBounds
     * @since 1.2
     */
    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }
}
