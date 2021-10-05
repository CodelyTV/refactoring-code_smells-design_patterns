import { Enemy } from "./Enemy";

export function cloneEnemy<T extends Enemy>(object: T): T {
  const clone = { ...object } as T;
  Object.setPrototypeOf(clone, Object.getPrototypeOf(object));
  return clone;
}
