#Name of output file
set output 'graph.ps'
# Set to PostScript output:
set terminal postscript portrait color enhanced 'Times-Roman' 10
# Set the bottom (BM), top (TM), left (LM) and right (RM) margins:
BM=0.045; TM = 0.01; LM = 0.07; RM = 0.02
#set bmargin BM; set tmargin TM; set lmargin LM; set rmargin RM
set size 1,1
set key left top
set title "Ehrenfeucht-Mycielski Compression Ratio"
set style line 1 lc rgb '#0060ad' lt 1 lw 2 pt 7 ps 0.5   # --- blue
#plot  "output.dat" with linespoint ls 1;
plot  "output.dat" with point ls 1;


