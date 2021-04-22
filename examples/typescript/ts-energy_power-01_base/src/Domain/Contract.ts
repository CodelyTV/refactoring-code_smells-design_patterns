export class Contract {
    constructor(
        private id: string,
        private contractedPower: number
    ) {}

    changePower(selectedPower: number): void {
        this.contractedPower = selectedPower
    }

    get power(): number {
        return this.contractedPower
    }
}