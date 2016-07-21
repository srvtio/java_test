program kptest4
  implicit none
  integer, parameter :: ncx = 32
  integer, parameter :: ncy = 32
  real(8), parameter :: kp1 = 0.0
  real(8), parameter :: kp2 = 100

  integer, parameter :: seed = 42
  integer, parameter :: npor = 550  !多孔質媒体の個数
  integer, parameter :: porsize = 1
  real(8) ep !空隙率

  integer i,j
  integer irep
  integer incx,incy

  integer xcell1,xcell2
  integer ycell1,ycell2
  integer xcell1p,xcell2m
  integer ycell1p,ycell2m

  integer count
  integer sumreg
  integer j0or1(ncx,ncy)

  integer fin_n !生成された多孔質媒体の個数

  integer KnudsenPt
  integer iPattern  !多孔質配置パターン
  integer iParallel !並列数

  real(8) kp(ncx,ncy)
  real(8) lbotx(1:npor),lboty(1:npor) !多孔質媒体を作る正方形領域の左下のセルの位置

  character filedata*128
  character filepara*128


  write(*,*) rf(23,7)

contains

  !------------------------------------------------------------------
  !   function rf
  !------------------------------------------------------------------

  real(8) function rf(iidum,ip)

    implicit none
    integer, intent(in) :: iidum,ip
    integer idum
    integer, save       :: ma(55,0:7),inext(0:7),inextp(0:7),iff(0:7)=0
    integer, parameter  :: mbig=1000000000,mseed=161803398,mz=0
    real(8), parameter  :: fac=1.d-9
    integer             :: mj,mk,i,ii,k

    idum = iidum + ip

    if((idum<0) .or. (iff(ip)==0)) then
       iff(ip) = 1
       mj = mseed-iabs(idum)
       mj = mod(mj,mbig)
       ma(55,ip) = mj
       mk = 1

       do i=1,54
          ii = mod(21*i,55)
          ma(ii,ip) = mk
          mk = mj - mk
          if(mk<mz) mk=mk+mbig
          mj = ma(ii,ip)
       end do

       do k=1,4
          do i=1,55
             ma(i,ip) = ma(i,ip) - ma(1+mod(i+30,55),ip)
             if(ma(i,ip)<mz) ma(i,ip) = ma(i,ip) + mbig
          end do
       end do

       inext(ip) = 0 
       inextp(ip) = 31
    end if

200 inext(ip)=inext(ip)+1
    if(inext(ip)==56) inext(ip)=1
    inextp(ip) = inextp(ip) + 1
    if(inextp(ip)==56) inextp(ip)=1
    mj = ma(inext(ip),ip) - ma(inextp(ip),ip)
    if(mj<mz) mj=mj+mbig
    ma(inext(ip),ip) = mj
    rf = mj * fac
    if((1.0d-8<rf) .and. (rf<0.99999999)) return
    go to 200

  end function rf

end program kptest4
