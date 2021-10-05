import { Enemy } from "./framework/Enemy";
import { Ghost } from "./Ghost";
import { Wolf } from "./Wolf";

export const enemiesEasyMode: Array<Enemy> = [
  new Ghost(1),
  new Ghost(2),
  new Wolf(1),
  new Wolf(2),
  new Wolf(3),
];
