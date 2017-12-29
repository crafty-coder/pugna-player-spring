package io.pugna.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoveController {

  private final MovementUseCase movementUseCase;

  @Autowired
  public MoveController(MovementUseCase movementUseCase) {
    this.movementUseCase = movementUseCase;
  }

  @PostMapping("/nextmove")
  public ResponseEntity<String> nextMove(@RequestBody MoveRequest moveRequest) {
    return ResponseEntity.ok(movementUseCase.execute(moveRequest));
  }
}
