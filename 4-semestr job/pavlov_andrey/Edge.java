/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package semestr8;

/**
 *
 * @author Андрей
 */
public class Edge implements Comparable<Edge> { 

    private final int v; // îäíà âåðøèíà
    private final int w; // äðóãàÿ âåðøèíà
    private final double weight; // âåñ ðåáðà
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight() {
        return weight;
    }
    
    public int getV(){
        return v;
    }
    
    public int getW(){
        return w;
    }
    public int compareTo(Edge that) {
        if      (this.weight() < that.weight()) return -1;
        else if (this.weight() > that.weight()) return +1;
        else                                    return  0;
    }
    public String toString() {
        return String.format("%d-%d %.5f", v, w, weight);
    }
}