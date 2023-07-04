'''Assume that a FDMA/TDMA communication channel has a total of___ bandwidth and 
each radio sub channel c has an assigned bandwidth of___ with a guard bandwith of _. 
Each sub channel is divided into ____ time slots. If each user is allocated a time slot, 
how many users can be supported by the communication channel totally?

Input Format

24.6 Mhz .2 Mhz .005 Mhz 8

Constraints

NUMBERS

Output Format

960

Sample Input 0

24.6 Mhz
.2 Mhz
.005 Mhz
8
Sample Output 0

960'''

# Given,
# Total bandwidth, tb
# Each channel bandwidth, c
# Guard band, g
# time slots, t
# To find,
# Total number of users supported by channel

#print("Enter the total bandwidth assigned: ")
a=input().split()
tb=float(a[0])
#print("Enter the channel bandwidth: ")
a=input().split()
c=float(a[0])
#print("Enter the guard band: ")
a=input().split()
g=float(a[0])
#print("Enter the number of time slots: ")
t=int(input())

temp1=c+g
temp2=int(tb/temp1)
no_of_users=temp2*t
print(no_of_users)
