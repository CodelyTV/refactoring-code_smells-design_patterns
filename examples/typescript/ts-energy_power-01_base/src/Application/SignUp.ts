import { ContractRepository } from "../Domain/ContractRepository"
import { Contract } from "../Domain/Contract"
import { InvalidPower } from "../Domain/InvalidPower"

export class SignUp {
    constructor(private repository: ContractRepository) {}

    async run(contractId: string, power: number) {
        if (
            power !== 1150 &&
            power !== 1725 &&
            power !== 2300 &&
            power !== 3450 &&
            power !== 4600 &&
            power !== 5750 &&
            power !== 6900 &&
            power !== 8050 &&
            power !== 9200
        ) {
            throw new InvalidPower(power)
        }

        const contract = new Contract(contractId, power)

        await this.repository.save(contract)
    }
}