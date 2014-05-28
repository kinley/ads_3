package semestrovka;

public class AvlTree {
 
	public class AvlNode {
		
		 public AvlNode left;
		 public AvlNode right;
		 public AvlNode parent;
		 public int key;
		 public int balance;

		 public AvlNode(int k) {
		  left = right = parent = null;
		  balance = 0;
		  key = k;
		 }
		

		}
	
 protected AvlNode root;  
 
 
 public boolean isEmpty(){
	 if(this.root != null)
		 return false;
	 else return true; 
 }
 
 public void insert(int k) {
  AvlNode n = new AvlNode(k);
  insertAVL(this.root,n);
 }
 public void insertAVL(AvlNode p, AvlNode q) {
  if(p == null) 
   this.root=q;
  else {
   
   if(q.key < p.key) {
    if(p.left == null) {
     p.left = q;
     q.parent = p;    
     Balance(p);
    } 
    else 
     insertAVL(p.left,q);    
   }
   else 
	   if(q.key > p.key) {
    if(p.right == null) {
     p.right = q;
     q.parent = p;
     Balance(p);
    }
    else 
     insertAVL(p.right,q);    
   } 
  }
 }

 public void Balance(AvlNode cur) {
  setBalance(cur);
  int balance = cur.balance;
  
  if(balance==-2) {  
   if(height(cur.left.left)>=height(cur.left.right)) 
    cur = rotateRight(cur);
   
   else 
    cur = doubleRotateLeftRight(cur);
   
  } 
  else 
	  if(balance==2) {
   if(height(cur.right.right)>=height(cur.right.left)) 
    cur = rotateLeft(cur);   
   else 
    cur = doubleRotateRightLeft(cur);
   
  }
  
  if(cur.parent!=null) 
   Balance(cur.parent); 
  else 
   this.root = cur;
  
 }

 public void delete(int k) {
	 deleteAVL(this.root,k);
 }
 

 public void deleteAVL(AvlNode p,int q) {
  if(p == null) 
   return; 
  else {
   if(p.key>q)  
	   deleteAVL(p.left,q); 
   else 
	   if(p.key<q) 
	   deleteAVL(p.right,q);
	   else 
		   if(p.key==q)
	   deleteFoundNode(p);
   
  }
 }

 public void deleteFoundNode(AvlNode q) {
  AvlNode r;
  if(q.left==null || q.right==null) {
   if(q.parent==null) {
    this.root=null;
    q=null;
    return;
   }
   r = q;
  } 
  else {
	  if(q.right != null) {
		   AvlNode z = q.right;
		   while(z.left!=null) {
		    z = z.left;
		   }
		  r=z;
		  } 
	  else {
		   AvlNode p = q.parent;
		   while(p!=null && q==p.right) {
		    q = p;
		    p = q.parent;
		   }
		   r = p;
		  }
   q.key = r.key;
  }
  
  AvlNode p;
  if(r.left!=null) 
   p = r.left; 
  else 
   p = r.right;
    
  if(p!=null) 
   p.parent = r.parent;
  
  if(r.parent==null) 
   this.root = p;
  else {
   if(r==r.parent.left) 
    r.parent.left=p;
   else 
    r.parent.right = p; 
    Balance(r.parent);
  }
  r = null;
 }
 
 
 public void deleteMin()
	{
	 AvlNode delete = this.findMin(root);
	 this.deleteFoundNode(delete);	 
	}

 private  AvlNode findMin(AvlNode t )
 {
     if( t == null )
         return t;
     while( t.left != null )
         t = t.left;
     return t;
 }
 
 public AvlNode rotateLeft(AvlNode n) {
  
  AvlNode v = n.right;
  v.parent = n.parent; 
  n.right = v.left;
  
  if(n.right != null) 
   n.right.parent = n;
  
  v.left = n;
  n.parent = v;
  
  if(v.parent != null) {
   if(v.parent.right == n) {
    v.parent.right = v;
   }
   else
	   if(v.parent.left==n) 
    v.parent.left = v;
   
  }
  
  setBalance(n);
  setBalance(v);
  
  return v;
 }
 
 
 public AvlNode rotateRight(AvlNode n) {
  
  AvlNode v = n.left;
  v.parent = n.parent;  
  n.left = v.right;
  
  if(n.left!=null) 
   n.left.parent=n;
  
  
  v.right = n;
  n.parent = v;
    
  if(v.parent!=null) {
   if(v.parent.right==n) 
    v.parent.right = v;
   
   else 
	   if(v.parent.left==n) 
        v.parent.left = v;
   
  }  
  setBalance(n);
  setBalance(v);
  
  return v;
 }

 public AvlNode doubleRotateLeftRight(AvlNode u) {
  u.left = rotateLeft(u.left);
  return rotateRight(u);
 }
 
 
 public AvlNode doubleRotateRightLeft(AvlNode u) {
  u.right = rotateRight(u.right);
  return rotateLeft(u);
 }

 
 private int height(AvlNode cur) {
  if(cur==null) {
   return -1;
  }
  if(cur.left==null && cur.right==null) {
   return 0;
  } else if(cur.left==null) {
   return 1+height(cur.right);
  } else if(cur.right==null) {
   return 1+height(cur.left);
  } else {
   return 1+max(height(cur.left),height(cur.right));
  }
 }
 
 
 private int max(int a, int b) {
  if(a>=b) {
   return a;
  } else {
   return b;
  }
 }

 
 public void show(AvlNode n) {
  int l = 0;
  int r = 0;
  int p = 0;
  if(n.left!=null) 
   l = n.left.key;
  
  if(n.right!=null) 
   r = n.right.key;
  
  if(n.parent!=null) 
   p = n.parent.key;
  
  
  System.out.println("Left: " + l + " Key: " + n.key + " Right: " + r + " Parent: " + p);
  
  if(n.left!=null) {
   show(n.left);
  }
  if(n.right!=null) {
   show(n.right);
  }
 }
 
 private void setBalance(AvlNode cur) {
  cur.balance = height(cur.right)-height(cur.left);
 }

 public boolean isconnected(int v, int w)
 {
	 AvlNode find1 =  find(v,root);
	 AvlNode find2 =  find(w,root);
	 if(find1.parent == find2||find2.parent == find1)
	 return true;
	 else
	 return false;
 }

public void union(int p, int q) {
   this.insert(p);
   this.insert(q);
 }


 private  AvlNode find(int x,AvlNode t)
 {
     while( t != null )
         if( x < t.key )
             t = t.left;
         else if( x > t.key  )
             t = t.right;
         else
             return t;   
     return null;   
 }
 
public static void main(String[] args) {
	
	
	AvlTree x = new AvlTree();
	x.insert(1);
	x.insert(3);
	x.insert(2);
	x.insert(4);
	x.insert(11);
	x.insert(123);
	
		x.show(x.root);
		x.delete(4);
		x.show(x.root);
		x.deleteMin();
		
}

 
}