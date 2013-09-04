from tkinter import *
from tkinter import ttk

def btn_Clicked():
    messagebox.showinfo(title="Hallo", message="Hallo Welt !")
    
fenster= Tk()    
fenster.title("Hallo Welt")
fenster.geometry("300x300")

frame = Frame(master=fenster, background="#ff0000", cursor="pirate")
frame.place(x=10, y=10, width=280, height=280)

btn = Button(master=frame, text="Hallo Welt", command=btn_Clicked)
btn.place(x=10, y=10)

pbr = ttk.Progressbar(master=frame, cursor="boat")
pbr.place(x=10, y=40)
pbr.start()

fenster.mainloop()
