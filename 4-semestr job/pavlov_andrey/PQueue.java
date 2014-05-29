/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package semestr8;

import java.util.Scanner;

/**
 *
 * @author Андрей
 */
class PQueue{
    private static final int MAX = 1100000;

    private class Entry{
        Comparable key;
        Edge value;
        Entry() {}
        Entry(Comparable _k, Edge _val){
            key=_k;
            value=_val;
        }
    }

    private Entry[] arr = new Entry[MAX+1];
    private int sz = 0;

    public int size(){
        return sz;
    }
    
    public boolean empty(){
        return sz==0;
    }

    public Object min()throws Exception{
        if(sz==0)
            throw new Exception("Empty queue!");
        return arr[1].value;
    }

    public void insert(Comparable key, Object value)throws Exception{
        if(sz==524288)
            throw new Exception("Overflow!");
        arr[++sz]= new Entry(key, (Edge) value);
        int ind = sz;
        while(ind>1){
            if(arr[ind].key.compareTo(arr[ind/2].key)<0){
                Entry tmp=arr[ind];
                arr[ind]=arr[ind/2];
                arr[ind/2]=tmp;
                ind/=2;
            }
            else
                break;
        }
    }

    public void removeMin() throws Exception{
        if(sz==0)
            throw new Exception ("Empty queue!");
        arr[1]=null;
        if(sz==1){
            sz=0;
            return;
        }
        arr[1]=arr[sz];
        arr[sz--]=null;
        int ind=1;
        while((arr[2*ind]!=null && arr[2*ind].key.compareTo(arr[ind].key)<0) || (arr[2*ind+1]!=null &&  arr[2*ind+1].key.compareTo(arr[ind].key)<0)){
            if(arr[2*ind]==null){
                Entry tmp=arr[ind];
                arr[ind]=arr[2*ind+1];
                arr[2*ind+1] = tmp;
                break;
            }
            if(arr[2*ind+1]==null){
                Entry tmp=arr[ind];
                arr[ind]=arr[2*ind];
                arr[2*ind] = tmp;
                break;
            }
            if(arr[2*ind].key.compareTo(arr[2*ind+1].key)<0){
                Entry tmp=arr[ind];
                arr[ind]=arr[2*ind];
                arr[2*ind] = tmp;
                ind=ind*2;
            }
            else{
                Entry tmp=arr[ind];
                arr[ind]=arr[2*ind+1];
                arr[2*ind+1] = tmp;
                ind=ind*2+1;
            }
        }
    }
    public PQueue(Scanner in) throws Exception {
    	int E = in.nextInt();
    	for (int i = 0; i < E; i++) {
    		int v = in.nextInt();
    		int w = in.nextInt();
    		double weight = in.nextDouble();
    		Edge e = new Edge(v, w, weight);
    		insert(e.weight(),e);
    	}
    }
}