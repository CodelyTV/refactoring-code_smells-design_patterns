import "./assets/css/normalize.css";
import "./assets/css/game.css";

import { enemiesEasyMode } from "./enemiesByLevel";
import { EnemiesByLevel } from "./framework/EnemiesByLevel";
import { MonstersGame } from "./framework/MonstersGame";

const enemiesByLevel = new EnemiesByLevel(enemiesEasyMode);
const game = new MonstersGame(enemiesByLevel);
game.run();
