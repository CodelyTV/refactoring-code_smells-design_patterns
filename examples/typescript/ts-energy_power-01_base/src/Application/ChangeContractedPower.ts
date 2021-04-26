import { ContractRepository } from '../Domain/ContractRepository'
import { ContractNotFound }   from '../Domain/ContractNotFound'
import { Contract }           from '../Domain/Contract'

export class ChangeContractedPower {
  constructor(private repository: ContractRepository) {
  }

  async run(contractId: string, newPower: number) {
    const contract = await this.repository.search(contractId)
    if (!contract) {
      throw new ContractNotFound(contractId)
    }

    Contract.ensurePowerIsNormalized(newPower)

    contract.changePower(newPower)

    await this.repository.save(contract)
  }
}
