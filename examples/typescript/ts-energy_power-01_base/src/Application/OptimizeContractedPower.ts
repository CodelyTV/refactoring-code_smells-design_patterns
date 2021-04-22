import { ContractRepository } from "../Domain/ContractRepository"
import { ContractNotFound } from "../Domain/ContractNotFound"
import { PowerOptimizer } from "../Domain/PowerOptimizer"

export class OptimizeContractedPower {
    constructor(
        private repository: ContractRepository,
        private optimizer: PowerOptimizer
    ) {}

    async run(contractId: string) {
        const contract = await this.repository.search(contractId)
        if (!contract) {
            throw new ContractNotFound(contractId)
        }

        const optimizedPower = this.optimizer.optimize()

        let power: number

        if (optimizedPower <= 1150) {
            power = 1150
        } else if (optimizedPower <= 1725) {
            power = 1725
        } else if (optimizedPower <= 2300) {
            power = 2300
        } else if (optimizedPower <= 3450) {
            power = 3450
        } else if (optimizedPower <= 4600) {
            power = 4600
        } else if (optimizedPower <= 5750) {
            power = 5750
        } else if (optimizedPower <= 6900) {
            power = 6900
        } else if (optimizedPower <= 8050) {
            power = 8050
        } else {
            power = 9200
        }

        contract.changePower(power)

        await this.repository.save(contract)
    }
}