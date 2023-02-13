import copy
class EightPuzzle:
    
    def __init__(self,currentstate,goal_state):
        self.currentstate=currentstate
        self.prevstate=None
        self.goalstate= goal_state
        

    def gstate(self):
        return self.currentstate == self.goalstate
    

    board= [' ' for x in range(10)]
    def printBoard(self):
        print('\n')
        print(' ' + str(self.currentstate[0]) + ' | ' + str(self.currentstate[1]) + '   | ' + str(self.currentstate[2]))
        print('   |     |   ')
        print('-------------')
        print('   |     |   ')
        print(' ' + str(self.currentstate[3]) + ' | ' + str(self.currentstate[4]) + '   | ' + str(self.currentstate[5]))

        print('-------------')
        print('   |     |   ')
        print(' ' + str(self.currentstate[6]) + ' | ' + str(self.currentstate[7]) + '   | ' + str(self.currentstate[8]))
        print('\n')

        

    def up(self):
        pos=self.currentstate.index(0)
        if pos>2:
            self.currentstate[pos-3],self.currentstate[pos]=self.currentstate[pos],self.currentstate[pos-3]
            #self.currentstate=self.currentstate
            #self.printBoard(self.currentstate)
            #print(self.currentstate,"up")
            return True
        else:
            return False
            

    def down(self):
        pos=self.currentstate.index(0)
        if pos<6:
            self.currentstate[pos+3],self.currentstate[pos]=self.currentstate[pos],self.currentstate[pos+3]
            self.currentstate=self.currentstate
            #self.printBoard(self.currentstate)
            #print(self.currentstate,"down")
            return True
        else:
            return False
            

    def right(self):
        pos=self.currentstate.index(0)
        if pos%3 != 2 :
            self.currentstate[pos+1],self.currentstate[pos]=self.currentstate[pos],self.currentstate[pos+1]
            #self.currentstate=self.currentstate
            #self.printBoard(self.currentstate)
            #print(self.currentstate,"right")
            return True
        else:
            return False
            

    def left(self):
        pos=self.currentstate.index(0)
        if pos%3 != 0 :
            self.currentstate[pos-1],self.currentstate[pos]=self.currentstate[pos],self.currentstate[pos-1]
            #self.currentstate=self.currentstate
            #self.printBoard(self.currentstate)
            return True
        else:
            return False

        
    def checkclosed(self, closed):
        for state in closed:
            if state.currentstate == self.currentstate:
                return True
        return False

        
def DFS(obj):
    open=[]
    closed=[]
    open.append(obj)
    
    while True:
        s = open.pop()
        
        if(s.gstate()):
            break
        
        c = copy.deepcopy(s)
        if c.down() and not c.checkclosed(closed):
            c.prevstate = s
            open.append(c)

        del c
        c = copy.deepcopy(s)
        if c.right() and not c.checkclosed(closed):
            c.prevstate = s
            open.append(c)

        del c 
        c = copy.deepcopy(s)
        if c.up() and not c.checkclosed(closed):
            c.prevstate = s
            open.append(c)

        del c   
        c = copy.deepcopy(s)
        if c.left() and not c.checkclosed(closed):
            c.prevstate = s
            open.append(c)

        closed.append(s)

    while s is not None:
        s.printBoard()
        s = s.prevstate


        
tanvi=EightPuzzle([2,0,3,1,8,4,7,6,5], [1,2,3,8,0,4,7,6,5])
"""
obj.gstate(obj.self.currentstate)
obj.printBoard(obj.self.currentstate)
obj.up(obj.self.currentstate)
obj.down(obj.self.currentstate)
obj.right(obj.self.currentstate)
obj.left(obj.self.currentstate)
"""
DFS(tanvi)
#checkclosed(obj)
