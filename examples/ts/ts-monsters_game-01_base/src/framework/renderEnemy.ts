import { Enemy } from "./Enemy";

export function renderEnemy(enemy: Enemy): void {
  const enemyContainer = document.createElement("p");
  enemyContainer.className = `enemy level-${enemy.level}`;
  enemyContainer.innerHTML = enemy.text();
  enemyContainer.style.position = "absolute";
  enemyContainer.style.top = `${Math.floor(Math.random() * 400) + 1}px`;
  enemyContainer.style.left = `${Math.floor(Math.random() * 600) + 1}px`;
  enemyContainer.addEventListener("click", () => {
    enemy.receiveDamage();
    if (enemy.died()) {
      document.body.removeChild(enemyContainer);
    }
  });
  document.body.appendChild(enemyContainer);
}
