professor <- data.frame(name = c("A", "B", "C", "D", "E"),
                        age = c(23,41,32,55,40) , 
                        sal = c(10000 , 20000 , 30000 , 40000 , 50000) , 
                        scount = c(10 , 20 , 30 , 50 , 60) , 
                        course = c("X" , "Y" , "Z" , "X" , "Y") , 
                        designation = c("Professor" ,"Associat Professor" , "Assistant Professor" , "Associate Professor" , "Professor") , 
                        remark = c("" , "" , "" , "" , "")
)

write.csv(professor, "\\professor.csv", row.names=FALSE)

print(professor)

print(cor(professor$scount , professor$sal))

boxplot(professor$name)

boxplot(course~designation,data=professor,main="Plotting",xlab="Course",ylab="Designation")

for (i in professor$sal)
{
  if(i > 20000)
  {
    print(i)
    print("High Salary")
  }
}

for (i in professor$sal)
{
  if(i > 40000)
  {
    print("Continued")
    professor$remark = "Continued"
  }
  
  else
  {
    print("Dis-Continued")
    professor$remark = "Dis-Continued"
  }
}





boxplot(iris$Petal.Length)
boxplot(Petal.Length~Species, data=iris)


boxplot(iris$Petal.Length)
boxplot(Petal.Length~Species, data=iris)
//////////////////////////////////////////////////

PetalReg <- lm(Petal.Width~Petal.Length, data=iris)
abline(PetalReg)
//////////////////////////////////////////////////////
sum(ds$Quantity_in_stock) / nrow(ds)
//////////////////////////////////////////////////////

current <- format(Sys.Date() ,format="%Y")

exp <- ds[ds$Exp_date < current, ]

exp

boxplot(exp$Exp_date~exp$Med_Name)
///////////////////////////////////////////////////////////
ds
barplot(ds$Sales, names.arg = ds$Manf_year, xlab = "Year", ylab = "Sales", col = "green", main = "Sales Chart")

/////////////////////////////////////////////
cor(ds$Quantity_in_stock, ds$Exp_date, method = "pearson")
//////////////////////////////////////////////////////////////////
ds <- read.csv("C:\\Users\\mitul\\OneDrive\\Desktop\\Big Data\\Exports\\DataSet.csv")

ds[(nrow(ds) - 4 + 1) : nrow(ds), ]
//////////////////////////////////////////////////////////////////////////
iris.class <- iris

iris.class$Calyx.Width = c()

for(i in 1:nrow(iris.class))
{
  if(iris.class[i, "Sepal.Length"] < 5)
      iris.class[i, "Calyx.Width"] = "short"
  else
      iris.class[i, "Calyx.Width"] = "long"
}

iris.class
////////////////////////////////////////////////////////////////////////
data("iris")
i<-iris
i

aggregate(x = i$Sepal.Width, by = list(i$Species), FUN = mean)

aggregate(x = i$Sepal.Length, by = list(i$Species), FUN = mean)


aggregate(x = i$Sepal.Width, by = list(i$Species), FUN = sd)

aggregate(x = i$Sepal.Length, by = list(i$Species), FUN = sd)
/////////////////////////////////////////////////////////////////////////////////
seq(1.3, 5, by = 0.3)

rep(seq(1, 4), 5)

seq(14, 0, length = 8)

rep(c(5, 12, 13, 20), rep(2, 4))
///////////////////////////////////////////////////////////////////////////
data("iris")
i <- iris
i
typeof(i)
nrow(i)
ncol(i)

for(col in colnames(i))
  cat(col, "\n", levels(factor(i[, col])), "\n\n")
  /////////////////////////////////////////////////////////////////
data("mtcars")
m <- mtcars
m
str(m)
names(m)

m[m$cyl >= 5, ]

m[1:10, ]

m[grep("Honda", rownames(m)), ]
