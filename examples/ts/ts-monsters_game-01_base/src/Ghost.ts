import { Enemy } from "./framework/Enemy";

export class Ghost implements Enemy {
  private readonly sprite: string;
  private health: number;

  constructor(public readonly level: number) {
    this.sprite = `👻`;
    this.health = level;
  }

  public clone(): Ghost {
    return new Ghost(this.level);
  }

  public text(): string {
    return `${this.sprite} ${this.health}`;
  }

  public receiveDamage(): void {
    this.health--;
  }

  public died(): boolean {
    return this.health === 0;
  }
}
