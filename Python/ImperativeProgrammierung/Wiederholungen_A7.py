######################################################
## Inf-Schule : Wiederholungen, Uebungen, Aufgabe 7 ##
######################################################

#http://inf-schule.de/informatik/imperativeprogrammierung/konzepteimp/wiederholungen/uebungen

basis = int(input("Basis :"))

for i in range(1, 11):
	print('{0:2d} mal {1:2d} ergibt {2:2d}'. format(i, basis, i*basis))
