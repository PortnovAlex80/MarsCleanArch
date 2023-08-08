rootProject.name = "NasaMarsRover"

include("rover")
include("rover:domain")
//findProject(":rover:domain")?.name = "domain"
include("rover:application")
findProject(":rover:application")?.name = "application"
//include("rover:adapter")
//findProject(":rover:adapter")?.name = "adapter"
//include("rover:adapter:web")
//findProject(":rover:adapter:web")?.name = "web"
//include("rover:adapter:persistence-inmemory")
//findProject(":rover:adapter:persistence-inmemory")?.name = "persistence-inmemory"

include("application")
