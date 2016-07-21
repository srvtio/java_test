set terminal eps
set pm3d map
set pm3d corners2color c2
set size ratio 1
set output "kp.eps"
unset colorbox
set palette rgbformulae 22,13,-31
set xrange [0:33]
set yrange [0:33]
set xlabel "xsite"
set ylabel "ysite"

splot "KnudsenData(CN1_32,CN2_32,pt153).dat" u 1:2:3  palette notitle
#splot "kp(32,32).dat" u 1:2:3 w p pt 5 ps 1.15 palette notitle

unset output
reset
#splot "test.dat" u 1:2:3 w p pt 5 ps 3.9 palette notitle
#-----------------------------------------------------

