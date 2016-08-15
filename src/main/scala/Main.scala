import processing.core.PApplet

class Main extends PApplet {
  var simulationMap: SimulationMap = _

  override def setup: Unit = {
    simulationMap = MapBuilder.createMap(System.getProperty("user.dir") + "/maps/map.txt")
    println(simulationMap)
  }
  
  
  override def settings: Unit = {
    size(800, 800)
  }

  override def draw: Unit = {
    simulationMap.draw(this)
  }
}

object Main {
  def main(args:Array[String]) {
    PApplet.main(Array("Main"))
  }



}
