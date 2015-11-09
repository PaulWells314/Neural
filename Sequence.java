import java.util.ArrayList;

abstract class Element {
   abstract void update();
   //abstract void Display();
}

class Link extends Element{

      Node n1;
      Neuron n2;
      double wt;
      double v;
      
      public Link(Node n1, Neuron n2, double wt)
      {
          this.n1 = n1;
          this.n2 = n2;
          this.wt = wt;
          n2.attachInput(this);
      }
     
      public void SetWeight(double wt)
      {  
          this.wt = wt;
      }
      public double getWeight() {   
          return this.wt;
      }
      public double getV() {
          return v; 
      }
      public void update() {
          v = wt* n1.getV();
          return;
      }
}
abstract class  Node extends Element {
   public abstract double getV();
}


class InputSignal  extends Node {

   public int count = 0;
   public double v = 1;
   public double getV() {
      return v;
   }
   public void update() {
      count = count +1;
      v = count * count;
      return;
   }

}

class Neuron extends Node{

     private double v;
     
     public Neuron() {
        inputs = new ArrayList<Link>();
     }
     private ArrayList<Link> inputs;
  
     public void attachInput(Link l){
         inputs.add(l);
     }
     public double getV() {
         return v;
     }
     public void update() {
         double v = 0;
         for (Link l : inputs) {
           v = v + l.getV();
         }
         this.v = v;
     } 
}

public class Sequence{

     ArrayList<Element> elements;
     
     public Sequence() {
        elements = new ArrayList<Element>();
     }
     
     public void addElement(Element e) {
        elements.add(e);
     }
     
     public void cycle()
     {
       for (Element e: elements ) {
          e.update();
       }
     }

     public static void main(String[] args) {
     
        InputSignal s1 = new InputSignal();
        Neuron n1 = new Neuron();
        Neuron n2 = new Neuron();
        Neuron n3 = new Neuron();
        Neuron n4 = new Neuron();
        
        Link l1= new Link(s1,n1,1.0);
        Link l2= new Link(s1,n2,1.0);
        Link l3= new Link(n2,n3,1.0);
        Link l4= new Link(n1,n4,1.0);
        Link l5= new Link(n3,n4,-1.0);
        
        
        Sequence s = new Sequence();
        
        s.addElement(n4);
        s.addElement(l5);
        s.addElement(l4);
        s.addElement(n3);
        s.addElement(l3);
        s.addElement(n2);
        s.addElement(n1);
        s.addElement(l2);
        s.addElement(l1);
        s.addElement(s1);
        
        for (int i=0; i < 30; i++) {
           s.cycle();
           System.out.println("Neuron n4: " + n1.getV()+" "+n2.getV()+" "+n3.getV()+" "+n4.getV() );
        }
     }
}