package com.marsrover.NasaMarsRover.usecases

import com.marsrover.NasaMarsRover.domain.interfaces.IPlateauInterface
import com.marsrover.NasaMarsRover.domain.interfaces.IRoverInterface
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class CommandCenterTest {

    private lateinit var commandCenter: CommandCenter
    private lateinit var plateau: IPlateauInterface
    private lateinit var rover: IRoverInterface

    @BeforeEach
    fun setUp() {
        plateau = mock(IPlateauInterface::class.java)
        rover = mock(IRoverInterface::class.java)
        commandCenter = CommandCenter(plateau)
    }

    @Test
    fun `When executeCommand is called with MOVE_FORWARD, it should call rover's moveForward method`() {
        commandCenter.addRover(rover)
        commandCenter.executeCommand(rover, RoverCommand.MOVE_FORWARD)

        verify(rover, times(1)).moveForward()
    }

    @Test
    fun `When executeCommand is called with TURN_LEFT, it should call rover's turnLeft method`() {
        commandCenter.addRover(rover)
        commandCenter.executeCommand(rover, RoverCommand.TURN_LEFT)

        verify(rover, times(1)).turnLeft()
    }

    @Test
    fun `When executeCommand is called with TURN_RIGHT, it should call rover's turnRight method`() {
        commandCenter.addRover(rover)
        commandCenter.executeCommand(rover, RoverCommand.TURN_RIGHT)

        verify(rover, times(1)).turnRight()
    }
}
