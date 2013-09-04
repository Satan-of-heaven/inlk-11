######################################################
## Inf-Schule : Wiederholungen, Uebungen, Aufgabe 4 ##
######################################################

#http://inf-schule.de/informatik/imperativeprogrammierung/konzepteimp/wiederholungen/uebungen

schulden = 1000.0
jahre = 0

while schulden > 0:
	schulden *= 1.06
	schulden -= 120.0
	jahre += 1
	print("Jahr " + str(jahre) + " : " + str(schulden))

print("Schulden abbezahlt nach " + str(jahre) + " Jahren")
