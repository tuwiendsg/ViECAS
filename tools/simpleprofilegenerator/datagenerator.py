#!/usr/bin/env python
import random
#By Hong-Linh Truong
#a simple data generator for scu simulation. We generate people, skill and availability
#after running the program, there are three files, people.csv, skill.csv, and availability.csv generated.
#using sqlite3 to create a database and run autoscript.txt to import csv data to sqlite.
#this data is read by Linh code

#pre-defined groups and their shortname
Group ={'BAS':'BusinessApplicationsServices','ECS':'EmailandCollaborationServices','WM':'WebMiddleware',
'DM':'DatabaseManagement','DC':'DatabaseCommunication','PSI':'PlatformSupportIntel','PSU':'PlatformSupportUnix',
'PHCAOS':'PatchingandHealthCheckingAllOS','PSM':'PlatformSupportMainframe','SDBR':'StorageDASDBackupRestore',
'PSMe':'PortableStorageMedia','COps':'ConsoleOps','POps':'ProductionOps','NS':'NetworkService',
'HSO':'HardwareStrategyOptimization','SSO':'SoftwareStategyOptimization','DRM':'DisasterRecoveryManagement'}
#level of skill
maxSkillLevel=5
#max nr skill per person
maxSkillPerPerson=5
#min and max group size
groupSizeMin=5
groupSizeMax=10
#base cost unit
costUnit = 10;
#we use simple database for testing
#open file for people: name,cost,org
peoplefile=open("people.csv","wb")
#pen file for skill: name, skill, weight
skillfile=open("skill.csv","wb")
#open file for availability: name, start, stop, timezone
availabilityfile=open("availability.csv","wb")
for shortName, fullName in Group.iteritems():
     groupSize=random.randint(groupSizeMin,groupSizeMax)
     for i in range(1,groupSize):
           personName=shortName+str(i)
           skill=fullName
           skillLevel=random.randint(1,maxSkillLevel)
           cost = costUnit*skillLevel
           nrSkill = random.randint(1,maxSkillPerPerson)
           #people, cost and group
           peoplefile.write(personName+","+ str(cost)+"," +fullName+"\n")
           #people and skill
           skillfile.write(personName +","+skill +","+ str(skillLevel)+"\n")
           for j in range(2,nrSkill):
                 skill = Group.values()[random.randint(0,len(Group)-1)]
                 if skill <> fullName:
		       skillLevel=random.randint(1,maxSkillLevel)
                       skillfile.write(personName +","+skill +","+ str(skillLevel)+"\n")
           #people and availability
           hours = random.sample([1,2,3,4,5,6,7,8], 2)
           start = min(hours)
           stop  = max(hours)
           timezone = random.randint(0,23)
           availabilityfile.write(personName +","+str(start)+","+str(stop)+","+str(timezone)+"\n")
#close files
peoplefile.close()
skillfile.close()
availabilityfile.close()
           
                 
 
