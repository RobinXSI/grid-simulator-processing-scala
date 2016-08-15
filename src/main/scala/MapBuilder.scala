import scala.io.Source

object MapBuilder {

  def createLineOfCellGrid(line: String, indexY: Int): Vector[Cell] = (for {
    (char, indexX) <- line.toList.zipWithIndex
  } yield new Cell(new Coordinate(indexX, indexY))).toVector

  def createCellGrid(pathToFile: String): Vector[Vector[Cell]] = (for {
      (line, indexY) <- Source.fromFile(pathToFile).getLines().zipWithIndex
    } yield createLineOfCellGrid(line, indexY)).toVector

  def createMap(filename: String): SimulationMap = {
    new SimulationMap(createCellGrid(filename))
  }
}
