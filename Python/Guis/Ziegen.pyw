from tkinter import *
from random import *

werte = [False, False, False]
stufeZwei = False
btn_geklickt = -1

def btn_box1_Clicked():
    global btn_geklickt
    btn_geklickt = 0
    
    btn_box1.config(bg="green")
    
    btn_box1.config(state=DISABLED)
    btn_box2.config(state=DISABLED)
    btn_box3.config(state=DISABLED)
    
    aufdecken()

def btn_box2_Clicked():
    global btn_geklickt
    btn_geklickt = 1
    
    btn_box2.config(bg="green")

    btn_box1.config(state=DISABLED)
    btn_box2.config(state=DISABLED)
    btn_box3.config(state=DISABLED)

    aufdecken()

def btn_box3_Clicked():
    global btn_geklickt
    btn_geklickt = 2
    
    btn_box3.config(bg="green")

    btn_box1.config(state=DISABLED)
    btn_box2.config(state=DISABLED)
    btn_box3.config(state=DISABLED)

    aufdecken()

def aufdecken() :
    global stufeZwei
    
    if(not stufeZwei) :
        rot = False
        for i in range(len(buttons)):
            btn = buttons[i]
            
            if(btn.cget("bg") != "green" and werte[i] == False and not rot):
                btn.config(image=img_ziege)
                btn.config(bg="red")
                rot = True
            if(btn.cget("bg") != "red") :
                btn.config(state=NORMAL)
            if(btn.cget("bg") == "green"):
                btn.config(image=img_tuer)
        stufeZwei = True
    else :
        for i in range(len(buttons)):
            btn = buttons[i]

            if(i != btn_geklickt):
                if(btn.cget("bg") != "red"):
                   btn.config(bg="gray")
            if(werte[i]) :
                btn.config(image=img_auto)
            else :
                btn.config(image=img_ziege)



win = Tk()
win.geometry("285x85")
win.title("Ziegenproblem")

win.maxsize(285,85)
win.minsize(285,85)

img_ziege = PhotoImage(file="z.gif", width =75, height= 75)
img_auto = PhotoImage(file="a.gif")
img_tuer = PhotoImage(file="t.gif")

btn_box1 = Button(win, text="1", image=img_tuer, command=btn_box1_Clicked)
btn_box2 = Button(win, text="2", image=img_tuer,command=btn_box2_Clicked)
btn_box3 = Button(win, text="3", image=img_tuer,command=btn_box3_Clicked)

buttons = [btn_box1, btn_box2, btn_box3]

btn_box1.place(x=5, y=5, width=75, height=75)
btn_box2.place(x=105, y=5, width=75, height=75)
btn_box3.place(x=205, y=5, width=75, height=75)

werte[randint(0, 2)] = True



win.mainloop()
