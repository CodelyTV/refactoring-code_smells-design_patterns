import { EnemiesByLevel } from "./EnemiesByLevel";
import { EnemySpawner } from "./EnemySpawner";
import { GameLevel } from "./GameLevel";

export class MonstersGame {
  private readonly gameLevel: GameLevel;
  private readonly enemySpawner: EnemySpawner;

  constructor(enemiesByLevel: EnemiesByLevel) {
    this.gameLevel = new GameLevel();
    this.enemySpawner = new EnemySpawner(this.gameLevel, enemiesByLevel);
  }

  public run(): void {
    const loop = (timestamp: number) => {
      this.enemySpawner.update(timestamp);
      this.gameLevel.update(timestamp);

      window.requestAnimationFrame(loop);
    };

    window.requestAnimationFrame(loop);
  }
}
