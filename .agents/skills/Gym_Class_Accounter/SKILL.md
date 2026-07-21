```markdown
# Gym_Class_Accounter Development Patterns

> Auto-generated skill from repository analysis

## Overview
This skill teaches you the core development patterns and conventions used in the Gym_Class_Accounter TypeScript codebase. You'll learn about file naming, import/export styles, commit message habits, and how to write and run tests. This guide also suggests useful commands to streamline your workflow.

## Coding Conventions

### File Naming
- Use **camelCase** for all file names.
  - Example: `userProfile.ts`, `classManager.test.ts`

### Imports
- Use **relative imports** for all modules.
  - Example:
    ```typescript
    import { getUser } from './userManager';
    ```

### Exports
- Use **named exports** rather than default exports.
  - Example:
    ```typescript
    // In classManager.ts
    export function addClass() { ... }
    export function removeClass() { ... }
    ```

### Commit Messages
- Freeform messages, sometimes with prefixes.
- Average commit message length: ~23 characters.
- Example:
  ```
  Add attendance tracking
  Fix bug in class removal
  ```

## Workflows

### Adding a New Feature
**Trigger:** When implementing a new functionality  
**Command:** `/add-feature`

1. Create a new TypeScript file using camelCase naming.
2. Write your feature using named exports.
3. Use relative imports to include dependencies.
4. Add or update corresponding test files (`*.test.ts`).
5. Commit your changes with a clear, concise message.

### Fixing a Bug
**Trigger:** When resolving a reported issue  
**Command:** `/fix-bug`

1. Locate the relevant file(s) using camelCase naming.
2. Apply your fix, maintaining code style conventions.
3. Update or add tests to cover the bug fix.
4. Commit with a message describing the fix.

### Writing Tests
**Trigger:** When adding or updating tests  
**Command:** `/write-test`

1. Create or update a test file matching `*.test.ts`.
2. Write tests for your functions or classes.
3. Use the same import/export conventions as production code.
4. Run tests (test framework not specified; see project docs or package.json).

## Testing Patterns

- Test files are named using the pattern `*.test.ts`.
- Tests are written in TypeScript.
- The specific testing framework is not detected; check project documentation or `package.json` for details.
- Example test file:
  ```typescript
  import { addClass } from './classManager';

  test('should add a new class', () => {
    // test logic here
  });
  ```

## Commands
| Command      | Purpose                                 |
|--------------|-----------------------------------------|
| /add-feature | Start the workflow for adding a feature |
| /fix-bug     | Start the workflow for fixing a bug     |
| /write-test  | Start the workflow for writing tests    |
```