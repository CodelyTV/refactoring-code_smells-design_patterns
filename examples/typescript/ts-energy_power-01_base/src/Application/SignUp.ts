import { ContractRepository } from "../Domain/ContractRepository"
import { Contract } from "../Domain/Contract"
import { InvalidPower } from "../Domain/InvalidPower"

export class SignUp {
    constructor(private repository: ContractRepository) {}

    async run(contractId: string, power: number) {
        Contract.ensurePowerIsNormalized(power)

        const contract = new Contract(contractId, power)

        await this.repository.save(contract)
    }
}
