public class RandomNum {

    public static void main(String[] args){
    	double a ;
	
    	a = random(23,7) ;

    	System.out.println(a) ;
	
    }

    public static double random(int iidum,int ip) {
	int idum ;
	int ma[][] = new int[56][8] ;
	int inext[] = new int[8] ;
	int inextp[] = new int[8] ;
	int iff[] = new int[8] ;
	int mbig = 1000000000 ;
	int mseed = 161803398 ;
	int mz = 0 ;
	double fac = 1.0e-9 ;
	int  mj = 0 ;
	int mk,i,ii,k ;
	double rf = 0.0 ;

	idum = iidum + ip ;

	if(idum<0 || iff[ip]==0) {
	    iff[ip] = 1 ;
	    mj = mseed - Math.abs(idum) ;
	    mj = mj % mbig ;
	    ma[55][ip] = mj ;
	    mk = 1 ;

	    for(i = 1 ; i < 55 ; i++){
		ii = (21*i) % 55 ;
		ma[ii][ip] = mk ;
		mk = mj - mk ;
		if(mk<mz){
		    mk = mk + mbig ;
		}
		mj = ma[ii][ip] ;
	    }

	    for(k = 1 ; k < 5 ; k++) {
		for(i = 1 ; i < 56 ; i++){
		    ma[i][ip] = ma[i][ip] - ma[1+((i+30)%55)][ip] ;
		    if(ma[i][ip]<mz) ma[i][ip] = ma[i][ip] + mbig ;
		}
	    }

	    inext[ip] = 0 ;
	    inextp[ip] = 31 ;
	}

	while((rf<1.0e-8) || (rf>0.99999999)){
	    inext[ip] = inext[ip] + 1 ;
	    if(inext[ip]==56) inext[ip] = 1 ;
	    inextp[ip] = inextp[ip] + 1 ;
	    if(inextp[ip]==56) inextp[ip]=1 ;
	    mj = ma[inext[ip]][ip] - ma[inextp[ip]][ip] ;
	    if(mj<mz) mj = mj + mbig ;
	    ma[inext[ip]][ip] = mj ;
	    rf = mj * fac ;
	}

	return rf ;

    }

}
