set ns [new Simulator] 
setnamfile [open s2.nam w] 
$ns namtrace-all $namfile  
settracefile[open s2.tr w] 
$ns trace-all $tracefile 
proc finish {} { 
global ns namfiletracefile 
$ns flush-trace  
close $namfile  
close $tracefile  
execnam s2.nam & 
execawk -f s2.awk s2.tr &  
exit 0 
} 
set n0 [$ns node]  
set n1 [$ns node]  
set n2 [$ns node]  
set n3 [$ns node]  
set n4 [$ns node]  
set n5 [$ns node]  
set n6 [$ns node] 
$ns duplex-link $n1 $n0 1Mb 10ms DropTail 
$ns duplex-link $n2 $n0 1Mb 10ms DropTail 
$ns duplex-link $n3 $n0 1.75Mb 20ms DropTail 
$ns duplex-link $n4 $n0 1Mb 10ms DropTail 
$ns duplex-link $n5 $n0 1Mb 10ms DropTail 
$ns duplex-link $n6 $n0 1Mb 10ms DropTail 
$ns duplex-link-op $n0 $n1 orient right 
$ns duplex-link-op $n0 $n2 orient left 
$ns duplex-link-op $n0 $n3 orient right-up 
$ns duplex-link-op $n0 $n4 orient right-down 
$ns duplex-link-op $n0 $n5 orient left-up 
$ns duplex-link-op $n0 $n6 orient left-down 
Agent/Ping instprocrecv {from rtt} { 
$self instvar node_ 
puts "node [$node_ id] received ping answer from $from with round-trip-time $rttms" }
set p1 [new Agent/Ping]  
set p2 [new Agent/Ping]  
set p3 [new Agent/Ping] 
set p4 [new Agent/Ping]  
set p5 [new Agent/Ping]  
set p6 [new Agent/Ping] 
$ns attach-agent $n1 $p1 
$ns attach-agent $n2 $p2 
$ns attach-agent $n3 $p3 
$ns attach-agent $n4 $p4 
$ns attach-agent $n5 $p5 
$ns attach-agent $n6 $p6 
$ns queue-limit $n0 $n4 1 
$ns queue-limit $n0 $n5 2 
$ns queue-limit $n0 $n6 2 
$ns connect $p1 $p4 
$ns connect $p2 $p5 
$ns connect $p3 $p6 
$ns at 0.2 "$p1 send" 
$ns at 0.4 "$p2 send" 
$ns at 0.6 "$p3 send" 
$ns at 1.0 "$p4 send" 
$ns at 1.2 "$p5 send" 
$ns at 1.4 "$p6 send" 
$ns at 2.0 "finish" 
$ns run 
















Output 
#gedit s2.tcl  
#sudo ns s2.tcl 
node 2 received ping answer from 5 with round-trip-time 42.0 ms.  node 3 received ping answer from 6 with round-trip-time 61.6 ms.  node 5 received ping answer from 2 with round-trip-time 42.0 ms.  node 6 received ping answer from 3 with round-trip-time 61.6 ms. 
No of packets dropped : 2
#xgraph -x "Bandwidth(Mbps)" -y "No of packets dropped" -t "Performance analysis" s1graph