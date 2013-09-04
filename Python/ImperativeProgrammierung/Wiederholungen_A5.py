######################################################
## Inf-Schule : Wiederholungen, Uebungen, Aufgabe 5 ##
######################################################

#http://inf-schule.de/informatik/imperativeprogrammierung/konzepteimp/wiederholungen/uebungen

zahl_dec = int(input("Zahl (Dezimal) :"))
x = zahl_dec
zahl_bin = ""

while x > 0:
	zahl_bin += str(x % 2)
	x = x // 2

print("[" + str(zahl_dec) + "]_10 = [" + str(zahl_bin) + "]_2")
