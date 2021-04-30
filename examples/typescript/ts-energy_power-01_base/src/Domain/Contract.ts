import {InvalidPower} from "./InvalidPower";

export class Contract {
    private static validNormalizedPowers: Array<number> = [
        1150,
        1725,
        2300,
        3450,
        4600,
        5750,
        6900,
        8050,
        9200
    ]

    constructor(
        private id: string,
        private contractedPower: number
    ) {
        // ensure is valid
    }

    get power(): number {
        return this.contractedPower
    }

    public static ensurePowerIsNormalized(newPower: number) {
        if (!this.validNormalizedPowers.includes(newPower)) {
            throw new InvalidPower(newPower)
        }
    }

    public static getMinimumPowerNeeded(optimizedPower: number) {
        if (optimizedPower <= 1150) {
            return 1150
        } else if (optimizedPower <= 1725) {
            return 1725
        } else if (optimizedPower <= 2300) {
            return 2300
        } else if (optimizedPower <= 3450) {
            return 3450
        } else if (optimizedPower <= 4600) {
            return 4600
        } else if (optimizedPower <= 5750) {
            return 5750
        } else if (optimizedPower <= 6900) {
            return 6900
        } else if (optimizedPower <= 8050) {
            return 8050
        } else {
            return 9200
        }
    }

    changePower(selectedPower: number): void {
        this.contractedPower = selectedPower
    }
}