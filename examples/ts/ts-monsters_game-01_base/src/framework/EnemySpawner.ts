import { cloneEnemy } from "./cloneEnemy";
import { EnemiesByLevel } from "./EnemiesByLevel";
import { GameLevel } from "./GameLevel";
import { renderEnemy } from "./renderEnemy";

const timeBetweenSpawnsInMilliseconds = 2000;

export class EnemySpawner {
  private nextSpawnTimestamp: number;

  constructor(
    private gameLevel: GameLevel,
    private enemiesByLevel: EnemiesByLevel
  ) {
    this.nextSpawnTimestamp = timeBetweenSpawnsInMilliseconds;
  }

  public update(currentTimestamp: number): void {
    if (currentTimestamp > this.nextSpawnTimestamp) {
      this.spawnEnemy();
      this.planNextSpawn(currentTimestamp);
    }
  }

  public spawnEnemy(): void {
    const currentLevel = this.gameLevel.currentLevel();
    const enemyPrototype = this.enemiesByLevel.enemyForLevel(currentLevel);
    const enemy = cloneEnemy(enemyPrototype);
    renderEnemy(enemy);
  }

  private planNextSpawn(currentTimestamp: number): void {
    this.nextSpawnTimestamp =
      currentTimestamp + timeBetweenSpawnsInMilliseconds;
  }
}
