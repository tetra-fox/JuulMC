# JuulMC
that's 50 nic

## prerequisites
1. a spigot/paper server (maybe bukkit too, i haven't tested this)
2. the resource pack **([JuulMC.zip](https://github.com/tetra-fox/JuulMC/releases/latest))**
3. minecraft 1.14+, the resource pack uses CustomModelData, a feature only present in 1.14 and beyond.

## demo
![demo](https://i.imgur.com/8DrduZZ.gif)

## commands
* `/juul` - gives the player a juul
  * usage: `/juul [amount]`
  
## permission nodes
* `juulmc.*` - grants a player all juulmc permissions
  * default: `false`
* `juulmc.command.use` - allows a player to use `/juul`
  * default: `op`
* `juulmc.craft` - allows a player to craft a juul
  * default: `true`
