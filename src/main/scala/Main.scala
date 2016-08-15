import processing.core.PApplet

class Main extends PApplet {
  var simulationMap: SimulationMap = _
  var gridVisualizer: GridVisualizer = _

  override def setup: Unit = {
    simulationMap = MapBuilder.createMap(System.getProperty("user.dir") + "/maps/map.txt")
    println(simulationMap)
    gridVisualizer = new GridVisualizer(this)
  }
  
  override def settings: Unit = {
    size(800, 800)
  }

  override def draw: Unit = {
    gridVisualizer.draw(simulationMap)
  }
}

object Main {
  def main(args:Array[String]) {
    PApplet.main(Array("Main"))
  }



}
