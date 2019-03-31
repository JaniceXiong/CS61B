class IntList{
    public int first;
    public IntList rest;

    public IntList(int f,IntList r){
        first = f;
        rest = r;
    }

    /** Return the size of the list using... recursion! */
    public int size(){
        if(this.rest!=null)
            return 1 + this.rest.size();
        else return 1; //base case
    }
    /** Return the size of the list using no recursion! */
    public int iteractiveSize(){
        int s = 1;
        IntList r = this.rest;
        while(r!=null){
            s++;
            r = r.rest;
        }
        return s;
    }

    //linear time
    /**Return the ith item of this IntList */
    public int get(int i){
        // int index = 0;
        // IntList p = this;
        // while(index < i){
        //     p = p.rest;
        //     index += 1;
        // }
        // return p.first;

        //recursion ver.
        if(i==0) return first;
        return rest.get(i-1);

    }

    /**
    Returns an IntList identical to L, but with all values incremented by x.
    Values in L cannot change!
    ps: my implement may get large O complexity?
     */
    public static IntList incrList(IntList L, int x){
        int s = L.size();
        IntList Q = new IntList(L.get(s-1) + x,null);
        for(int i = s-2; i>=0;i--){
            Q = new IntList(L.get(i) + x,Q);
        }
        
        return Q;
    }

    /**
    Returns an IntList identical to L, but with all values incremented by x.
    Not allowed to use ‘new’ (to save memory).
     */
    public static IntList dincrList(IntList L, int x){
        IntList Q = L;
        IntList p = Q;
        while(p!=null){
            p.first += x;
            p = p.rest;
        }
        return Q;
    }
    public static void main(String[] args){
        IntList L = new IntList(15,null);
        L = new IntList(10,L);
        L = new IntList(5,L);
        int s = L.size();
        // System.out.println(L.size());
        // System.out.println(L.iteractiveSize());

        // System.out.println(L.get(0));
        // System.out.println(L.get(1));
        // System.out.println(L.get(2));

        IntList Q1 = IntList.incrList(L,2);
        System.out.println("Q1: first item = " + Q1.first + ", last item = " + Q1.get(s-1));
        System.out.println("L: first item = " + L.first + ", last item = " + L.get(s-1));
        
        IntList Q2 = IntList.dincrList(L,2);
        System.out.println("Q2: first item = " + Q2.first + ", last item = " + Q2.get(s-1));
        System.out.println("L: first item = " + L.first + ", last item = " + L.get(s-1));

    }
}