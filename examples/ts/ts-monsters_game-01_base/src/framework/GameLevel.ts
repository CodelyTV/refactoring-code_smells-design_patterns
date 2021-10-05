const levelDurationInMilliseconds = 10000;

export class GameLevel {
  private level: number;
  private nextLevelTimestamp: number;

  constructor() {
    this.level = 1;
    this.nextLevelTimestamp = levelDurationInMilliseconds;
  }

  public currentLevel(): number {
    return this.level;
  }

  public update(currentTimestamp: number): void {
    if (currentTimestamp > this.nextLevelTimestamp) {
      this.levelUp();
      this.render();
      this.planNextLevelUp(currentTimestamp);
    }
  }

  public levelUp(): void {
    this.level++;
  }

  public planNextLevelUp(currentTimestamp: number): void {
    this.nextLevelTimestamp = currentTimestamp + levelDurationInMilliseconds;
  }

  public render(): void {
    const $level = document.querySelector("#level > span");
    if ($level) {
      $level.textContent = String(this.level);
    }
  }
}
