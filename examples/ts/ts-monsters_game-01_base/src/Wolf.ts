import { Enemy } from "./framework/Enemy";

export class Wolf implements Enemy {
  private readonly sprite: string;
  private health: number;

  constructor(public readonly level: number) {
    this.sprite = `🐺`;
    this.health = 2 + level * 2;
  }

  public text(): string {
    return `${this.sprite} ${this.level}`;
  }

  public receiveDamage(): void {
    this.health--;
  }

  public died(): boolean {
    return this.health === 0;
  }
}
