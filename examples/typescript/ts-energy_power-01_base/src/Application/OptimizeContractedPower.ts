import { ContractRepository } from "../Domain/ContractRepository"
import { ContractNotFound } from "../Domain/ContractNotFound"
import { PowerOptimizer } from "../Domain/PowerOptimizer"
import {Contract} from "../Domain/Contract";

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

        power = Contract.getMinimumPowerNeeded(optimizedPower);

        contract.changePower(power)

        await this.repository.save(contract)
    }

    private getMinimumPowerNeeded(optimizedPower: number) {
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
}