from tkinter import *
# Ereignisverarbeitung

def buttonVerdoppelnClick():
    # Verwaltung der Daten
    zahl = int(entryZahl.get())
    # Verarbeitung der Daten
    zahl = zahl * 2
    # Anzeige der Daten
    entryZahl.delete(0, 'end')
    entryZahl.insert(0, str(zahl))

# Erzeugung des Fensters
tkFenster = Tk()
tkFenster.title('Test')
tkFenster.geometry('120x110')
# Eingabefeld für die Zahl
entryZahl = Entry(master=tkFenster, bg='white')
entryZahl.place(x=45, y=40, width=30, height=30)
# Button zum Auswerten
buttonVerdoppeln = Button(master=tkFenster, text='verdoppeln', command=buttonVerdoppelnClick)
buttonVerdoppeln.place(x=10, y=80, width=100, height=20)
# Aktivierung des Fensters
tkFenster.mainloop()
