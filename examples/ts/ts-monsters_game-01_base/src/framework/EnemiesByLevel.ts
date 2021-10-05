import { Enemy } from "./Enemy";

export class EnemiesByLevel {
  constructor(private enemiesByLevel: Array<Enemy>) {}

  public enemyForLevel(level: number): Enemy {
    const index = Math.min(level - 1, this.enemiesByLevel.length - 1);
    return this.enemiesByLevel[index];
  }

  public setEnemyForLevel(level: number, enemy: Enemy): void {
    this.enemiesByLevel[level] = enemy;
  }

  public registerAll(enemiesByLevel: Array<Enemy>): void {
    this.enemiesByLevel = enemiesByLevel;
  }
}
