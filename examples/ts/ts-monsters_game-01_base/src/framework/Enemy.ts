export interface Enemy {
  readonly level: number;
  receiveDamage: () => void;
  died: () => boolean;
  text: () => string;
}
