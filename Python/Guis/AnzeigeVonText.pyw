# Daten
tag = 21
monat = 'Januar'
wochentag = 'Montag'
# GUI
from tkinter import *
# Erzeugung des Fensters
tkFenster = Tk()
tkFenster.title('Kalender')
tkFenster.geometry('130x145')
# Label für die Anzeige der Daten
labelMonat = Label(master=tkFenster, text=monat, fg="#000000", font=('Arial', 12))
labelMonat.place(x=5, y=5, width=120, height=20)
labelTag = Label(master=tkFenster, text=str(tag), fg="#ff0000", bg="#f7819f", font=('Arial', 32))
labelTag.place(x=5, y=30, width=120, height=80)
labelWochentag = Label(master=tkFenster, text=wochentag, fg="#000000", font=('Arial', 12))
labelWochentag.place(x=35, y=115, width=60, height=30)
# Aktivierung des Fensters
tkFenster.mainloop()
