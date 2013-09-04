######################################################
## Inf-Schule : Wiederholungen, Uebungen, Aufgabe 2 ##
######################################################

#http://inf-schule.de/informatik/imperativeprogrammierung/konzepteimp/wiederholungen/uebungen

x = int(input("x (N, x > 1):"))
y = int(input("y (N, y > 1):"))

while y > 0:
	h = x % y
	x = y
	y = h

print("x : " + str(x))
