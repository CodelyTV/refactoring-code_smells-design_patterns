import { InvalidPower } from './InvalidPower'

export class Contract {
    constructor(
        private id: string,
        private contractedPower: number
    ) {
        // ensure is valid
    }

    changePower(selectedPower: number): void {
        this.contractedPower = selectedPower
    }

    get power(): number {
        return this.contractedPower
    }

    public static ensurePowerIsNormalized(newPower: number): void {
        const validNormalizedPowers: Array<number> = [
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

        if (!validNormalizedPowers.includes(newPower)) {
            throw new InvalidPower(newPower)
        }
    }

}
