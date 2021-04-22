import { ContractRepository } from "../Domain/ContractRepository"
import { ContractNotFound } from "../Domain/ContractNotFound"
import { InvalidPower } from "../Domain/InvalidPower"

export class ChangeContractedPower {
    constructor(private repository: ContractRepository) {}

    async run(contractId: string, newPower: number) {
        const contract = await this.repository.search(contractId)
        if (!contract) {
            throw new ContractNotFound(contractId)
        }

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

        contract.changePower(newPower)

        await this.repository.save(contract)
    }
}